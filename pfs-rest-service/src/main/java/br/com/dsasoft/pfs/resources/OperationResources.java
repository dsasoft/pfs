package br.com.dsasoft.pfs.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/operation")
public class OperationResources {

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	static class OperationRequest{
		
		private String date;
		private String amount;
		private String center;
		private String account;
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getAmount() {
			return amount;
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
	}
	
	@POST
	@Consumes("application/json")
	@Path("save")
	public Response save( OperationRequest a ){
		return Response.status(201).entity("{\"property\":\"value\"}").build();
	}
}
