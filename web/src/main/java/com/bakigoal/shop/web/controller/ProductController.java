package com.bakigoal.shop.web.controller;

import com.bakigoal.shop.server.model.Product;
import com.bakigoal.shop.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  //------------------- Retrieve List --------------------------------------------------------
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Product>> list(@RequestParam(name = "name", required = false) String name) {
    List<Product> all = name == null ? productService.getAll() : productService.findByName(name);
    if (all.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(all, HttpStatus.OK);
  }

  //------------------- Retrieve --------------------------------------------------------
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> get(@PathVariable("id") int id) {
    Product topic = productService.get(id);
    if (topic == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(topic, HttpStatus.OK);
  }

  //------------------- Create --------------------------------------------------------
  @PostMapping
  public ResponseEntity<Void> add(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
    Serializable id = productService.save(product);

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(id).toUri());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  //------------------- Delete --------------------------------------------------------
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Product> remove(@PathVariable("id") int id) {
    Product topic = productService.get(id);
    if (topic == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    productService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  //------------------- Update --------------------------------------------------------
  @PutMapping(value = "/{id}")
  public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable("id") int id) {
    Product current = productService.get(id);
    if (current == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    current.setName(product.getName());
    current.setUnitPrice(product.getUnitPrice());

    productService.update(current);
    return new ResponseEntity<>(current, HttpStatus.OK);
  }

}
