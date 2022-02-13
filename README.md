# ProductService

<h1> TABLE PRODUCT</h1>

1. FindAll:

url: http://localhost:8080/api/product?page=1&limit=4

method:get

2. getByCategoryID:

url: http://localhost:8080/api/product/category/3?page=1&limit=3

method:get

3. getBuSupplierID:

url:http://localhost:8080/api/product/supplier/2?page=1&limit=1

method:get

4. getById:
url:http://localhost:8080/api/product/4
method:get

5. searchByName:

url:http://localhost:8080/api/product/search/Áo 001?page=1&limit=2

method:get

6. SearchByCategoryIdand Name:

url:http://localhost:8080/api/product/category/2/Áo?page=1&limit=2

method:get

7. Add product:

url:http://localhost:8080/api/product/add

method:post

Truyền vào:

{
        "name": "quần 002",
        "avatar": "https://png.pngtree.com/element_origin_min_pic/16/07/13/145785d8f43eb3e.jpg",
        "supplierId": 2,
        "price": 100000.0,
        "amount": 100,
        "discount": 0.0,
        "warranty": 12,
        "createdAt": "2022-01-20T17:00:00.000+00:00",
        "createdBy": 1,
        "updatedBy": null,
        "updatedAt": null,
        "deletedAt": null,
        "deletedBy": null,
        "viewNumber": 0,
        "categoryId": 6
}

8. update Product:

url:http://localhost:8080/api/product/update

method:post

Truyền vào:

{
        "id": 4,
        "name": "quần thun 002",
        "avatar": "https://png.pngtree.com/element_origin_min_pic/16/07/13/145785d8f43eb3e.jpg",
        "supplierId": 2,
        "price": 100000.0,
        "amount": 100,
        "discount": 0.1,
        "warranty": 12,
        "createdAt": "2022-01-20T17:00:00.000+00:00",
        "createdBy": 1,
        "updatedBy": null,
        "updatedAt": null,
        "deletedAt": null,
        "deletedBy": null,
        "viewNumber": 0,
        "categoryId": 6
}

9. delete Product:

url:http://localhost:8080/api/product/delete/4

method:post

Truyền vào: id (id này chỉ là biến bình thường không phải là 1 object nên k có {})
![image](https://user-images.githubusercontent.com/93043199/150798598-4fb158dd-16eb-48a8-9588-a90851ca16ac.png)

10. findByCategoryAndSupplier

url: http://localhost:8080/api/product/category/3/supplier/3?page=1&limit=3

method: get

11.FindByCategoryAndSupplierAndName

url:http://localhost:8080/api/product/category/2/supplier/3/name?name=Á&page=1&limit=3

method: get

<h1>TABLE IMAGE</h1>

1. FindByProduct

url: http://localhost:8080/api/image/product/1

method: Get

2. findById

url: http://localhost:8080/api/image/1

method: Get

3. addImage

url: http://localhost:8080/api/image

method: Post

Truyền vào: 

{
    "url": "https://dongphuczavi.vn/wp-content/uploads/2020/07/Cach-chup-anh-quan-ao-dep-01.png",
    "product": {
        "id": 1,
        "name": "Áo 001",
        "avatar": "https://png.pngtree.com/element_origin_min_pic/16/07/13/145785d8f43eb3e.jpg",
        "supplierId": 2,
        "price": 100000.0,
        "amount": 100,
        "discount": 0.0,
        "warranty": 12,
        "createdAt": "2022-01-20T17:00:00.000+00:00",
        "createdBy": 1,
        "updatedBy": null,
        "updatedAt": null,
        "deletedAt": null,
        "deletedBy": null,
        "viewNumber": 5,
        "categoryId": 2
    }
}

4. deleteByid

url: http://localhost:8080/api/image/delete/9

method: Post

<h1>TABLE ATTRIBUTE</h1>

1. findById

url: http://localhost:8080/api/attribute/2

method: GET

2. findByProductId

url: http://localhost:8080/api/attribute/product/2

method: GET

3. add ATTRIBUTE

url: http://localhost:8080/api/attribute

method: POST

TRUYỀN VÀO : Truyền vào 1 list object attribute KHÔNG CÓ ID chứ không phải 1 object

[
    {
        "size": "S",
        "amount": 50,
        "product": {
            "id": 2,
            "name": "Áo 002",
            "avatar": "https://png.pngtree.com/element_origin_min_pic/16/07/13/145785d8f43eb3e.jpg",
            "supplierId": 3,
            "price": 1.0E7,
            "discount": 0.0,
            "warranty": 12,
            "createdAt": "2022-01-20T17:00:00.000+00:00",
            "description": null,
            "createdBy": 1,
            "updatedBy": null,
            "updatedAt": null,
            "deletedAt": null,
            "deletedBy": null,
            "viewNumber": 100,
            "categoryId": 3
        }
    },
    {
        "size": "M",
        "amount": 50,
        "product": {
            "id": 2,
            "name": "Áo 002",
            "avatar": "https://png.pngtree.com/element_origin_min_pic/16/07/13/145785d8f43eb3e.jpg",
            "supplierId": 3,
            "price": 1.0E7,
            "discount": 0.0,
            "warranty": 12,
            "createdAt": "2022-01-20T17:00:00.000+00:00",
            "description": null,
            "createdBy": 1,
            "updatedBy": null,
            "updatedAt": null,
            "deletedAt": null,
            "deletedBy": null,
            "viewNumber": 100,
            "categoryId": 3
        }
    }
]

4. update

url: http://localhost:8080/api/attribute/update

method: POST

Truyền vào: Truyền vào 1 list object attribute CÓ ID chứ không phải 1 object

[
    {
        "id":3,
        "size": "S",
        "amount": 100,
        "product": {
            "id": 2,
            "name": "Áo 002",
            "avatar": "https://png.pngtree.com/element_origin_min_pic/16/07/13/145785d8f43eb3e.jpg",
            "supplierId": 3,
            "price": 1.0E7,
            "discount": 0.0,
            "warranty": 12,
            "createdAt": "2022-01-20T17:00:00.000+00:00",
            "description": null,
            "createdBy": 1,
            "updatedBy": null,
            "updatedAt": null,
            "deletedAt": null,
            "deletedBy": null,
            "viewNumber": 100,
            "categoryId": 3
        }
    },
    {
        "id":4,
        "size": "M",
        "amount": 100,
        "product": {
            "id": 2,
            "name": "Áo 002",
            "avatar": "https://png.pngtree.com/element_origin_min_pic/16/07/13/145785d8f43eb3e.jpg",
            "supplierId": 3,
            "price": 1.0E7,
            "discount": 0.0,
            "warranty": 12,
            "createdAt": "2022-01-20T17:00:00.000+00:00",
            "description": null,
            "createdBy": 1,
            "updatedBy": null,
            "updatedAt": null,
            "deletedAt": null,
            "deletedBy": null,
            "viewNumber": 100,
            "categoryId": 3
        }
    }
]
