package com.zensar.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.bean.Cart;
import com.zensar.bean.Product;
import com.zensar.db.CartDAO;

@Service
public class CartService {

	@Autowired
	CartDAO dao;

	public Cart addProductToCart(Cart cart, Product product, int quantity) {
		cart.getProducts().put(product, quantity);
		return this.dao.save(cart);
	}

	public Cart updateProductQuantity(Cart cart, Product product, int quantity) {
		cart.getProducts().put(product, quantity);
		return this.dao.save(cart);
	}

	public List<Cart> getAllCart() {
		return this.dao.findAll();
	}

	public Cart removeProductFromCart(Cart cart, Product product) {
		cart.getProducts().remove(product);
		return this.dao.save(cart);
	}

	public Cart removeAllProducts(Cart cart) {
		cart.getProducts().clear();
		return this.dao.save(cart);
	}

}