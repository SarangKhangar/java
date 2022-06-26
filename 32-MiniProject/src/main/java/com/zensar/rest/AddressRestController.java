package com.zensar.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.zensar.bean.Address;
import com.zensar.service.AddressService;

@RestController
public class AddressRestController {

	@Autowired
	AddressService service;

	@PostMapping("/addaddredd")
	public Address f1(@RequestBody Address address) {
		return this.service.addAddress(address);
	}

	@GetMapping("/findaddress/{Id}")
	public Address f2(@PathVariable(name = "Id") Integer Id) {
		return this.service.viewByAddress(Id);
	}

	@PutMapping("/updateaddress/{Id}")
	public Address f3(@RequestBody Address address, @PathVariable(name = "Id") Integer Id) {
		return this.service.updateAddressById(address, Id);
	}

	@DeleteMapping("/deleteaddress/{id}")
	public boolean f4(@PathVariable(name = "id") Integer id) {
		return service.removeAddress(id);
	}

	@GetMapping("/getalladdress")
	public List<Address> f5() {
		return this.service.viewAllAddresses();
	}

}
