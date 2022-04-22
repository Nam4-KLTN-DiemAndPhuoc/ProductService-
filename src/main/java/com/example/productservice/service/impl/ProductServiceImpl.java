package com.example.productservice.service.impl;

import com.example.productservice.common.Constants;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import com.example.productservice.vo.Category;
import com.example.productservice.vo.Product_Category_Supplier;
import com.example.productservice.vo.Supplier;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private RestTemplate restTemplate;
    @Retry(name = "basic")
    @Override
    public List<Product_Category_Supplier> findAll(Pageable pageable) {
        List<Product_Category_Supplier> list= new ArrayList<>();
        List<Product> listProduct =  repository.findByDeletedAtIsNull(pageable);
        return getProduct_category_suppliers(list, listProduct);
    }

    @Override
    public Product findById(Long id) {
         Product product= repository.findById(id).get();
         product.setViewNumber(product.getViewNumber()+1);
         repository.save(product);

        return repository.save(product);
    }
    @Retry(name = "basic")
    @Override
    public List<Product_Category_Supplier> findByName(String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList = repository.findByNameContainingAndDeletedAtIsNull(name, pageable);
        return getProduct_category_suppliers(list, productList);
    }


    @Retry(name = "basic")
    @Override
    public List<Product_Category_Supplier> findByCategoryid(Long categoryId, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findByCategoryIdAndDeletedAtIsNull(categoryId,pageable);
        return getProduct_category_suppliers(list, productList);
    }
    @Retry(name = "basic")
    @Override
    public List<Product_Category_Supplier> findByCategoryAndNameLike(Long categoryId, String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findByCategoryIdAndNameContainingAndDeletedAtIsNull(categoryId,name,pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Override
    public List<Product_Category_Supplier> findBySupplierAndNameLike(Long categoryId, String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findBySupplierIdAndNameContainingAndDeletedAtIsNull(categoryId,name,pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Retry(name = "basic")
    @Override
    public List<Product_Category_Supplier> findBySupplierId(Long id, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findBySupplierIdAndDeletedAtIsNull(id, pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Retry(name = "basic")
    @Override
    public Product_Category_Supplier addProduct(Product product) {
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        Category category=restTemplate.getForObject(Constants.CATEGORY +"/"+product.getCategoryId(),Category.class) ;
        Supplier supplier =restTemplate.getForObject(Constants.SUPPLIER+"/"+product.getSupplierId(),Supplier.class);
        if(category != null && supplier !=null){

            Product p = repository.save(product);
            return new Product_Category_Supplier(p,category,supplier);

        }
        return  null;
    }

    @Override
    public List<Product_Category_Supplier> findByDeletedAtIsNulldOrderByUpdatedAtDesc(Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findByDeletedAtIsNullOrderByUpdatedAtDesc(pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Retry(name = "basic")
    @Override
    public Product_Category_Supplier update(Product product) {
        product.setUpdatedAt(new Date());
        Category category=restTemplate.getForObject(Constants.CATEGORY +"/"+product.getCategoryId(),Category.class) ;
        Supplier supplier =restTemplate.getForObject(Constants.SUPPLIER+"/"+product.getSupplierId(),Supplier.class);
        if(category != null && supplier !=null){
            product.setUpdatedAt(new Date());
            Product p = repository.save(product);
            return new Product_Category_Supplier(p,category,supplier);

        }
        return null;
    }

    @Override
    public Product delete(Long id,Long idUser) {
        Product product= repository.findById(id).get();

        if(product != null ){
            product.setDeletedAt(new Date());
            product.setDeletedBy(idUser);
            Product p= repository.save(product);

        }
        return product;
    }
    @Retry(name = "basic")
    @Override
    public List<Product_Category_Supplier> findByCategoryIdAndSupplierId(Long idCategory, Long idSupplier,Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList = repository.findByCategoryIdAndSupplierIdAndDeletedAtIsNull(idCategory,idSupplier,pageable);

        return getProduct_category_suppliers(list,productList);
    }

    @Retry(name = "basic")
    @Override
    public List<Product_Category_Supplier> findByCategoryAndSupplierAndName(Long idCategory, Long idSupplier, String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList = repository.findByCategoryIdAndSupplierIdAndNameContainingAndDeletedAtIsNull(idCategory,idSupplier,name,pageable);
        return getProduct_category_suppliers(list,productList);
    }

    @Override
    public List<Product_Category_Supplier> findTop3ProductByviewNumber() {
        System.out.println("");
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList=repository.findTop3ProductByviewNumber();
        System.out.println("ss"+ productList.size());
        return getProduct_category_suppliers(list,productList);
    }

    @Override
    public List<Product_Category_Supplier> findAllOrderPriceAsc(Pageable pageable) {
        List<Product_Category_Supplier> list= new ArrayList<>();
        List<Product> listProduct =  repository.findByDeletedAtIsNullOrderByPriceAsc(pageable);
        return getProduct_category_suppliers(list, listProduct);
    }

    @Override
    public List<Product_Category_Supplier> findAllOrderPriceDesc(Pageable pageable) {
        List<Product_Category_Supplier> list= new ArrayList<>();
        List<Product> listProduct =  repository.findByDeletedAtIsNullOrderByPriceDesc(pageable);
        return getProduct_category_suppliers(list, listProduct);
    }

    @Override
    public List<Product_Category_Supplier> findByCategoryidAsc(Long categoryId, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findByCategoryIdAndDeletedAtIsNullOrderByPriceAsc(categoryId,pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Override
    public List<Product_Category_Supplier> findByCategoryDesc(Long categoryId, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findByCategoryIdAndDeletedAtIsNullOrderByPriceDesc(categoryId,pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Override
    public List<Product_Category_Supplier> findByCategoryAndNameLikeAsc(Long categoryId, String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findByCategoryIdAndNameContainingAndDeletedAtIsNullOrderByPriceAsc(categoryId,name,pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Override
    public List<Product_Category_Supplier> findByCategoryAndNameLikeDesc(Long categoryId, String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList= repository.findByCategoryIdAndNameContainingAndDeletedAtIsNullOrderByPriceDesc(categoryId,name,pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Override
    public List<Product_Category_Supplier> findByNameAsc(String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList = repository.findProductsByNameContainingAndDeletedAtIsNullOrderByPriceAsc(name, pageable);
        return getProduct_category_suppliers(list, productList);
    }

    @Override
    public List<Product_Category_Supplier> findByNameDesc(String name, Pageable pageable) {
        List<Product_Category_Supplier> list = new ArrayList<Product_Category_Supplier>();
        List<Product> productList = repository.findProductsByNameContainingAndDeletedAtIsNullOrderByPriceDesc(name, pageable);
        return getProduct_category_suppliers(list, productList);
    }


    // get list product_categoru_supplier
    private List<Product_Category_Supplier> getProduct_category_suppliers(List<Product_Category_Supplier> list, List<Product> productList) {
        for (Product product :productList ) {
            Category category=restTemplate.getForObject(Constants.CATEGORY +"/"+product.getCategoryId(),Category.class) ;
            Supplier supplier =restTemplate.getForObject(Constants.SUPPLIER+"/"+product.getSupplierId(),Supplier.class);
            list.add(new Product_Category_Supplier(product,category,supplier));
        }
        return list;
    }
    public List<Product_Category_Supplier> getFallback(List<Product_Category_Supplier> list, List<Product> productList, RuntimeException runtimeException){
        for (Product product :productList ) {
            Product_Category_Supplier pcs= new Product_Category_Supplier();
            pcs.setProduct(product);
            list.add(pcs);
        }
        return list;
    }

}
