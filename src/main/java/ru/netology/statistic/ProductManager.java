package ru.netology.statistic;

public class ProductManager {
    private ProductRepo repo;

    public ProductManager(ProductRepo repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] findAll() {
        return repo.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (product.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        Product[] tmp1 = new Product[result.length];
        for (int i = 0; i < result.length; i++) {
            tmp1[i] = result[result.length - 1 -i];
        }
        result = tmp1;
        return result;
    }


}


