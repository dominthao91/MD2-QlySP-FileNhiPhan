import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product>productList = new ArrayList<>();
        productList.add(new Product("1","IphoneX","Apple",1000,"note1"));
        productList.add(new Product("2","Iphone11","Apple",1000,"note2"));
        productList.add(new Product("3","Iphone12","Apple",1000,"note3"));
        productList.add(new Product("4","Iphone13","Apple",1000,"note4"));
        writeToFile(productList);
        readObject();

    }
    public static void writeToFile(List<Product> productList){
        try{
            //tạo liên kết với file
            OutputStream os = new FileOutputStream("demo.txt");
            //tạo đối tượng con của ObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(os);
            //viết danh sách đó vào file
            oos.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readObject(){
        try {
            //tạo liên kết với file để đọc
            InputStream is = new FileInputStream("demo.txt");
            //tạo đối tượng con của ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(is);
            //tạo list để hứng phẩn tử sau khi đọc từ file
            List<Product> newProductList = (List<Product>)ois.readObject();
            for (Product p:newProductList) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
