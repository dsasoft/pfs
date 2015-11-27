package br.com.dsasoft.pfs.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.ObjectMapper;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.com.dsasoft.pfs.entity.CenterEntity;
import br.com.dsasoft.pfs.entity.OperationEntity;
import br.com.dsasoft.pfs.facade.CenterFacade;
import br.com.dsasoft.pfs.facade.OperationFacade;

@Path("/operation")
public class OperationResources {

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	static class OperationRequest {

		private String date;
		private String amount;
		private String center;
		private String account;
		private String description;
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getAmount() {
			// Matcher m =
			// Pattern.compile("[+-]?[0-9]{1,3}(?:,?[0-9]{3})*\\,[0-9]{2}$").matcher(amount);
			// if(m.find()){
			// for(int i = 0; i < m.groupCount(); i++)
			// System.out.println(m.group(i));
			// amount = m.group();
			// amount = amount.replace(".", "");
			// amount = amount.replaceAll(",", ".");
			return amount;
			// }else
			// return "0";
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getCenter() {
			return center;
		}

		public void setCenter(String center) {
			this.center = center;
		}

		public String getAccount() {
			return account;
		}

		public void setAccount(String account) {
			this.account = account;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	}

	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("save")
	public Response save(OperationRequest opRequest) throws Exception {

		OperationEntity op = new OperationEntity();		

		// CurrencyUnit unit = CurrencyUnit.ofCountry("BRL");

		Money money = Money.parse(opRequest.getAmount());
		
		op.setAmount(money.getAmount());
		
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		DateTime dt = dtFormatter.parseDateTime(opRequest.getDate());
		
		op.setDate(dt.toDate());
		
		op.setDescription(opRequest.getDescription());
		
		CenterFacade centerFacade = new CenterFacade(null);
		
		CenterEntity center = centerFacade.findById(new Long(opRequest.getCenter()));
		op.setCenter(center);
		
		OperationFacade facade = new OperationFacade(null);
		facade.create(op);
		
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(op);
		
		return Response.status(201).entity(json).build();
	}
}
