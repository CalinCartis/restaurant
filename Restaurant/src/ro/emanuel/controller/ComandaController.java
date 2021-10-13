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

import ro.emanuel.dao.ComandaDAO;
import ro.emanuel.pojo.Comanda;

@Controller
public class ComandaController {

	// Read list
	@RequestMapping(value = "listComenzi.htm", method = RequestMethod.GET)
	public ModelAndView listaComenzi() throws SQLException {
		ModelMap model = new ModelMap();
		ArrayList<Comanda> comenzi = ComandaDAO.getComenzi();
		model.put("comenzi", comenzi);
		return new ModelAndView("Comanda/list.jsp", model);
	}

	// Read details
	@RequestMapping(value = "detaliiComanda.htm", method = RequestMethod.GET)
	public ModelAndView detailsComanda(@RequestParam Integer id) throws SQLException {
		ModelMap model = new ModelMap();

		Comanda c = ComandaDAO.getComandaById(id);
		model.put("comanda", c);

		return new ModelAndView("Comanda/detalii.jsp", model);
	}

	// Create
	@RequestMapping(value = "adaugare-comanda.htm", method = RequestMethod.GET)
	public ModelAndView showAddComanda(Model model) {
		Comanda c = new Comanda();
		model.addAttribute("comandaForm", c);

		return new ModelAndView("Comanda/add.jsp", "model", model);
	}

	@RequestMapping(value = "adaugare-comanda-save.htm", method = RequestMethod.POST)
	public ModelAndView addComanda(@ModelAttribute("comandaForm") Comanda c, ModelMap model, BindingResult result) {
		try {
			ComandaDAO.createComanda(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/listComenzi.htm");
	}

	// Update
	@RequestMapping(value = "editare-comanda.htm", method = RequestMethod.GET)
	public ModelAndView showEditComanda(@RequestParam Integer id, Model model) throws SQLException {
		Comanda c = ComandaDAO.getComandaById(id);
		model.addAttribute("comandaForm", c);

		return new ModelAndView("Comanda/edit.jsp", "model", model);
	}

	@RequestMapping(value = "editare-comanda-save.htm", method = RequestMethod.POST)
	public ModelAndView editComanda(@ModelAttribute("comandaForm") Comanda c, ModelMap model, BindingResult result) {
		try {
			ComandaDAO.updateComanda(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/listComenzi.htm");
	}

	// Delete
	@RequestMapping(value = "deleteComanda.htm", method = RequestMethod.GET)
	public ModelAndView deleteComanda(@RequestParam Integer id) throws SQLException {
		ComandaDAO.deleteComanda(id);

		return new ModelAndView("redirect:/listComenzi.htm");
	}

}
