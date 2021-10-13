package ro.emanuel.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.emanuel.dao.ClientDAO;
import ro.emanuel.pojo.Client;

@Controller
public class ClientController {

	// Read list
	@RequestMapping(value = "listClienti.htm", method = RequestMethod.GET)
	public ModelAndView listClients() throws SQLException {
		ModelMap model = new ModelMap();
		ArrayList<Client> clienti = ClientDAO.getClienti();
		model.put("clienti", clienti);
		return new ModelAndView("Client/list.jsp", model);
	}

	// Read details
	@RequestMapping(value = "detaliiClient.htm", method = RequestMethod.GET)
	public ModelAndView detailsClient(@RequestParam Integer id) throws SQLException {
		ModelMap model = new ModelMap();

		Client c = ClientDAO.getClientById(id);
		model.put("client", c);

		return new ModelAndView("Client/detalii.jsp", model);
	}

	// Create
	@RequestMapping(value = "adaugare-client.htm", method = RequestMethod.GET)
	public ModelAndView showAddClient(Model model) {
		Client c = new Client();
		model.addAttribute("clientForm", c);

		return new ModelAndView("Client/add.jsp", "model", model);
	}

	@RequestMapping(value = "adaugare-client-save.htm", method = RequestMethod.POST)
	public ModelAndView addClient(@ModelAttribute("clientForm") Client c, ModelMap model, BindingResult result) {
		try {
			ClientDAO.createClient(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/listClienti.htm");
	}

	// Update
	@RequestMapping(value = "editare-client.htm", method = RequestMethod.GET)
	public ModelAndView showEditClient(@RequestParam Integer id, Model model) throws SQLException {
		Client c = ClientDAO.getClientById(id);
		model.addAttribute("clientForm", c);

		return new ModelAndView("Client/edit.jsp", "model", model);
	}

	@RequestMapping(value = "editare-client-save.htm", method = RequestMethod.POST)
	public ModelAndView editClient(@ModelAttribute("clientForm") Client c, ModelMap model, BindingResult result) {
		try {
			ClientDAO.updateClient(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/listClienti.htm");
	}

	// Delete
	@RequestMapping(value = "deleteClient.htm", method = RequestMethod.GET)
	public ModelAndView deleteClient(@RequestParam Integer id) throws SQLException {
		ClientDAO.deleteClient(id);

		return new ModelAndView("redirect:/listClienti.htm");
	}

}
