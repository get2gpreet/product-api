package com.preet.product.service;

import com.preet.product.model.Product;
import com.preet.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

//    @PostConstruct
//    public void initDB(){
//        List<Product> productList = IntStream.rangeClosed(1,200)
//                .mapToObj(i -> new Product("product" +i, new Random().nextInt(100) , new Random().nextInt(5000)))
//                .collect(Collectors.toList());
//        productRepo.saveAll(productList);
//    }


    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> findAllProductsWithSort(String field){
        return productRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public Page<Product> findAllProductsWithPagination(int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize));
    }

    public Page<Product> findAllProductsWithPaginationAndSort(int offset, int pageSize, String field) {
        return productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
    }
}
