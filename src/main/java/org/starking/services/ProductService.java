package org.starking.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.starking.dtos.ProductDTO;
import org.starking.entities.ProductEntity;
import org.starking.repositories.ProductRepository;

@ApplicationScoped
public class ProductService {

	@Inject
	private ProductRepository productRepository;

	public List<ProductDTO> findAll() {
		List<ProductDTO> products = new ArrayList<>();

		this.productRepository.findAll().stream().forEach(item -> {
			products.add(mapCustomerEntityToDTO(item));
		});
		return products;
	}
	
	public void createNewProduct(ProductDTO dto) {
		this.productRepository.persist(mapCustomerDTOToModel(dto));
	}
	
	private ProductEntity mapCustomerDTOToModel(ProductDTO dto) {
		ProductEntity model = new ProductEntity();

		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setCategory(dto.getCategory());
		model.setPrice(dto.getPrice());
		model.setModel(dto.getModel());

		return model;
	}

	private ProductDTO mapCustomerEntityToDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();

		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setCategory(entity.getCategory());
		dto.setPrice(entity.getPrice());
		dto.setModel(entity.getModel());

		return dto;
	}
}
