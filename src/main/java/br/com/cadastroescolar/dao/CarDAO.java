package br.com.cadastroescolar.dao;

import br.com.cadastroescolar.model.Car;
import config.ConnectionPoolConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CarDAO {
    public void createCar(Car car) {
        String sql = "INSERT INTO CADASTRO (NAME,CPF,RG,NASCIMENTO,EMAIL,TELEFONE,CEP,LOGRADOURO,COMPLEMENTO) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Success in connection");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setString(2, car.getCpf());
            preparedStatement.setString(3, car.getRg());
            preparedStatement.setString(4, car.getNascimento());
            preparedStatement.setString(5, car.getEmail());
            preparedStatement.setString(6, car.getTelefone());
            preparedStatement.setString(7, car.getCep());
            preparedStatement.setString(8, car.getLogradouro());
            preparedStatement.setString(9, car.getComplemento());

            preparedStatement.execute();

            System.out.println("Success in insert");

            connection.close();

        } catch (Exception e) {
            System.out.println("Error in connection insert");
        }
    }

    public List<Car> findAllCars() {
        String sql = "SELECT * FROM CADASTRO";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Success in connection");

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                String carId = resultSet.getString("id");
                String carName = resultSet.getString("name");
                String carCpf = resultSet.getString("cpf");
                String carRg = resultSet.getString("rg");
                String carNascimento = resultSet.getString("nascimento");
                String carEmail = resultSet.getString("email");
                String carTelefone = resultSet.getString("telefone");
                String carCep = resultSet.getString("cep");
                String carLogradouro = resultSet.getString("logradouro");
                String carComplemento = resultSet.getString("complemento");

                Car car = new Car(carId,carName, carCpf,carRg,carNascimento, carEmail, carTelefone, carCep, carLogradouro, carComplemento);

                cars.add(car);
            }
            System.out.println("Success in select * car");
            connection.close();

            return cars;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }
    }
    public void deleteCarBy(String carId){
        String SQL = "DELETE CADASTRO WHERE ID = ?";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Success in connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carId);
            preparedStatement.execute();

            System.out.println("Success in insert");

            connection.close();

        }catch (Exception e){

            System.out.println("fail in database connection");
        }
    }

    public void deleteCarById(String carId) {
        String SQL = "DELETE CAR WHERE ID = ?";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, carId);
            preparedStatement.execute();

            System.out.println("success in delete car with id: " + carId);

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }
    }
}
