package br.com.cadastroescolar.servlet;

import br.com.cadastroescolar.dao.CarDAO;
import br.com.cadastroescolar.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastre-se")
public class CreateCadServLet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("car-id");
        String carName = req.getParameter("car-name");
        String carCpf = req.getParameter("car-cpf");
        String carRg = req.getParameter("car-rg");
        String carNascimento = req.getParameter("car-nascimento");
        String carEmail = req.getParameter("car-email");
        String carTelefone = req.getParameter("car-telefone");
        String carCep = req.getParameter("car-cep");
        String carLogradouro = req.getParameter("car-logradouro");
        String carComplemento = req.getParameter("car-complemento");

        Car car = new Car(carId,carName,carCpf,carRg,carNascimento,carEmail,carTelefone,carCep,carLogradouro,carComplemento);

        new CarDAO().createCar(car);

        resp.sendRedirect("/find-all-cars");
    }
}
