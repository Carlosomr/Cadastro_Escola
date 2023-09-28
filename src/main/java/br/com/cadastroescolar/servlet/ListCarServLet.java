package br.com.cadastroescolar.servlet;

import br.com.cadastroescolar.dao.CarDAO;
import br.com.cadastroescolar.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-cars")
public class ListCarServLet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = new CarDAO().findAllCars();

        req.setAttribute("cars", cars);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }
}