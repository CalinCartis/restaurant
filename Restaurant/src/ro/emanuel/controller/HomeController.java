package ro.emanuel.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.dao.ClientDAO;
import ro.emanuel.dao.RestaurantDAO;
import ro.emanuel.dao.ComandaDAO;


@Controller
public class HomeController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView countClients() throws SQLException {
		ModelMap model = new ModelMap();
		int clienti = ClientDAO.countClienti();
		model.put("clienti", clienti);
		int restaurante = RestaurantDAO.countRestaurante();
		model.put("restaurante", restaurante);
		int comenzi = ComandaDAO.countComenzi();
		model.put("comenzi", comenzi);
		return new ModelAndView("home.jsp", model);
	}
	
}
