package utils.demo;

import utils.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DbUtilsDemo {


    public static void main(String[] args) throws SQLException {


        DBUtils.createConnection();


        List<List<Object>> listOfLists = DBUtils.getQueryResultAsListOfLists("select * from users LIMIT 100");

        System.out.println(listOfLists);

        for (List<Object> row : listOfLists) {

            System.out.println(row);

        }


        System.out.println(listOfLists.get(0).get(4));


        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("select * from users LIMIT 100");

        System.out.println(listOfMaps);

        for (Map<String, Object> row : listOfMaps) {
            System.out.println(row);
        }

        System.out.println(listOfMaps.get(0).get("email"));


        List<String> columnNames = DBUtils.getColumnNames("select * from users LIMIT 1");

        System.out.println(columnNames);

        DBUtils.executeUpdate("UPDATE users SET lastName='Brown', firstName='Robert' where id=46 ");

        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("select * from users LIMIT 1");

        System.out.println(list);


    }
}
