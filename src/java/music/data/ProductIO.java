package music.data;

import java.io.*;
import java.util.*;
import music.business.*;

public class ProductIO {

    private static ArrayList<Product> products = null;

    public static ArrayList<Product> getProducts(String path) {
        try{
            Scanner read = new Scanner(new File(path));
            ArrayList<Product> danhSach = new ArrayList<Product>();
            while(read.hasNextLine()){
                String[] arr = read.nextLine().split("\\|");
                danhSach.add(new Product(arr[0], arr[1], Double.parseDouble(arr[2])));
            }
            return danhSach;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return new ArrayList();    
    }

    public static Product getProduct(String productCode, String path) {
        try{
            Scanner read = new Scanner(new File(path));
            ArrayList<Product> danhSach = new ArrayList<Product>();
            while(read.hasNextLine()){
                String[] arr = read.nextLine().split("\\|");
                danhSach.add(new Product(arr[0], arr[1], Double.parseDouble(arr[2])));
            }
            Product p = new Product();
            for(Product x: danhSach){
                if(x.getCode().equals(productCode)){
                    p = x;
                    break;
                }
            }
            return p;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return new Product();
    }

    public static boolean exists(String productCode, String path) {
        products = getProducts(path);
        for (Product p : products) {
            if (productCode != null && productCode.equalsIgnoreCase(p.getCode())) {
                return true;
            }
        }
        return false;
    }

    private static void saveProducts(ArrayList<Product> products,String path) {
        try {
            File file = new File(path);
            PrintWriter out = new PrintWriter(new FileWriter(file));
            for (Product p : products) {
                out.println(p.getCode() + "|" + p.getDescription() + "|" + p.getPrice());
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert(Product product, String path) {
        products = getProducts(path);
        products.add(product);
        saveProducts(products, path);
    }

    public static void update(Product product, String path) {
        products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product.getCode() != null
                    && product.getCode().equalsIgnoreCase(p.getCode())) {
                products.set(i, product);
            }
        }
        saveProducts(products, path);
    }

    public static void delete(Product product, String path) {
        products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product != null
                    && product.getCode().equalsIgnoreCase(p.getCode())) {
                products.remove(i);
            }
        }
        saveProducts(products, path);
    }
}
