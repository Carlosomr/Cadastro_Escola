package br.com.cadastroescolar.dao;

import br.com.cadastroescolar.model.User;

import java.sql.*;

public class UserDao {

    public boolean verifyCredentials(User user){

        String SQL = "SELECT * FROM LOGIN WHERE USERNAME =  ?";

            try {
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
                System.out.println("Success in connection");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, user.getUsername());
                ResultSet resultSet = preparedStatement.executeQuery();

                System.out.println("Success in select username");

                while (resultSet.next()){
                  String password =  resultSet.getString("password");

                  if (password.equals(user.getPassword())){
                      return true;
                  }
                }


                connection.close();
                return false;

            }catch (Exception e) {

                System.out.println("Error: " + e.getMessage());

                return false;
            }


    }
}
