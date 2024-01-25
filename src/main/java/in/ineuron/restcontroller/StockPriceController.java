package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping(value = "/api/price")
public class StockPriceController {
	
	@Autowired
	private IStockPriceService service;
	
	@GetMapping(value = "/stockPrice/{companyName}")
	public ResponseEntity<Double> fetchStockPriceByCompanyName(@PathVariable(value = "companyName") String companyName){
		Double stockPrice = service.findByCompanyName(companyName);
		return new ResponseEntity<Double>(stockPrice, HttpStatus.OK);
	}

}
