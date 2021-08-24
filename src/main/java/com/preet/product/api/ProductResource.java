package com.preet.product.api;

import com.preet.product.model.APIResponse;
import com.preet.product.model.Product;
import com.preet.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public APIResponse<List<Product>> getAllProduct(){
        List<Product> productList = productService.findAllProducts();
        return new APIResponse<>(productList.size(),productList);
    }

    @GetMapping(value = "/product/sort/{field}")
    public APIResponse<List<Product>> getAllProductWithSort(@PathVariable String field){
        List<Product> productList = productService.findAllProductsWithSort(field);
        return new APIResponse<>(productList.size(),productList);
    }


    @GetMapping(value = "/product/pagination/{offset}/{pageSize}")
    public APIResponse<List<Product>> getAllProductWithPagination(@PathVariable int offset,@PathVariable int pageSize){
        Page<Product> productListWithPagination = productService.findAllProductsWithPagination(offset, pageSize);
        return new APIResponse(productListWithPagination.getSize(),productListWithPagination);
    }

    @GetMapping(value = "/product/paginationAndSort/{offset}/{pageSize}/{field}")
    public APIResponse<List<Product>> getAllProductWithPaginationAndSort(@PathVariable int offset,@PathVariable int pageSize,
                                                                         @PathVariable String field){
        Page<Product> productListWithPagination = productService.findAllProductsWithPaginationAndSort(offset, pageSize,field);
        return new APIResponse(productListWithPagination.getSize(),productListWithPagination);
    }


}
