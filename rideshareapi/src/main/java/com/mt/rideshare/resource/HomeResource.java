package com.mt.rideshare.resource;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home redirection to swagger api documentation
 */
@Controller
public class HomeResource {

	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<Health> checkAppHealth() {
		Health health = new Health();
		health.setStatus("UP");
		return new ResponseEntity<>(health, HttpStatus.OK);
	}

	class Health {

		private String status;
		
		private String soaService;
		
		private String servedBy;
		
	
		public String getSoaService() {
			return soaService;
		}

		public void setSoaService(String soaService) {
			this.soaService = soaService;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getServedBy() {
			return servedBy;
		}

		public void setServedBy(String servedBy) {
			this.servedBy = servedBy;
		}

	}
}
