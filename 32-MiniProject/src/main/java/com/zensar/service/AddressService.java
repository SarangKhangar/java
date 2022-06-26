package com.zensar.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.bean.Address;
import com.zensar.db.AddressDAO;

@Service
public class AddressService {

	@Autowired
	AddressDAO dao;

	public Address addAddress(Address address) {
		return this.dao.save(address);
	}

	public Address viewByAddress(int id) {
		return this.dao.findById(id).get();
	}


	public Address updateAddressById(Address address, int id) {
		Optional<Address> optional = dao.findById(id);
        if(optional.isPresent()) {
		return dao.save(address);
        }
        return address;
	}
		
		

	public boolean removeAddress(int addressId) {
		Optional<Address> optional = dao.findById(addressId);
		if (optional != null) {
			this.dao.deleteById(addressId);
            return true;
		}
		else {
		return false;
		}
	}

	public List<Address> viewAllAddresses() {
		return this.dao.findAll();
	}
}
