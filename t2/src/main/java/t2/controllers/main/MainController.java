package t2.controllers.main;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import t2.controllers.models.Products;
import t2.controllers.models.User;

@Controller
public class MainController {

  @GetMapping("/")
  public String home(
      Model model) {
    model.addAttribute("message", "Hello, World!");
    return "index";
  }

  @GetMapping("/productos")
  public String getProducts(Model model) {
    List<Products> products = List.of(
        new Products("1", "Product 1", 10.0),
        new Products("2", "Product 2", 20.0),
        new Products("3", "Product 3", 30.0));
    model.addAttribute("products", products);
    return "products";
  }

  @GetMapping("/profile")
  public String getProfile(Model model) {
    boolean darkMode = true;
    User user = new User("John Tenno", "johntenno117@hotmail.com", "https://github.com/johntenno",
        List.of("Angular", "NestJS", "Unity", "C++", "C", "Ruby on rails", "MongoDB", "PrismaDb", "Esp32", "Ardruino"));
    model.addAttribute("darkMode", darkMode);
    model.addAttribute("user", user);
    return "profile";
  }
}
