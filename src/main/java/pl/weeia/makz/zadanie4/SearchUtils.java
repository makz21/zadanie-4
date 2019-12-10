package pl.weeia.makz.zadanie4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchUtils {
    private static final String BASE_PATH = "https://adm.edu.p.lodz.pl/user/users.php?search=";


    public Set<User> getUsers(String name) {
        return new HashSet<>(getUsersFromPLodzSearch(name));
    }

    private List<User> getUsersFromPLodzSearch(String name) {
        List<User> userList = new ArrayList<>();
        Document doc = null;
        String[] splitStr = name.split("\\s+");
        try {
            if (splitStr.length == 1) {
                doc = Jsoup.connect(BASE_PATH + name).get();
                Elements userInfoList = doc.select("div.user-info");
                Elements userNames = userInfoList.select("h3");
                userNames.forEach(element -> userList.add(new User(element.text())));
            } else {
                doc = Jsoup.connect(BASE_PATH + splitStr[0] + "+" + splitStr[1]).get();
                Elements userInfoList = doc.select("div.user-info");
                Elements userNames = userInfoList.select("h3");
                userNames.forEach(element -> userList.add(new User(element.text())));
            }
            System.out.println(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

}
