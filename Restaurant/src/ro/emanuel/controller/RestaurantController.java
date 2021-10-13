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

import ro.emanuel.dao.RestaurantDAO;
import ro.emanuel.pojo.Restaurant;

@Controller
public class RestaurantController {

	// Read list
		@RequestMapping(value = "listRestaurante.htm", method = RequestMethod.GET)
		public ModelAndView listRestaurants() throws SQLException {
			ModelMap model = new ModelMap();
			ArrayList<Restaurant> restaurante = RestaurantDAO.getRestaurante();
			model.put("restaurante", restaurante);
			return new ModelAndView("Restaurant/list.jsp", model);
		}

		// Read details
		@RequestMapping(value = "detaliiRestaurant.htm", method = RequestMethod.GET)
		public ModelAndView detailsRestaurant(@RequestParam Integer id) throws SQLException {
			ModelMap model = new ModelMap();

			Restaurant r = RestaurantDAO.getRestaurantById(id);
			model.put("restaurant", r);

			return new ModelAndView("Restaurant/detalii.jsp", model);
		}

		// Create
		@RequestMapping(value = "adaugare-restaurant.htm", method = RequestMethod.GET)
		public ModelAndView showAddRestaurant(Model model) {
			Restaurant r = new Restaurant();
			model.addAttribute("restaurantForm", r);

			return new ModelAndView("Restaurant/add.jsp", "model", model);
		}

		@RequestMapping(value = "adaugare-restaurant-save.htm", method = RequestMethod.POST)
		public ModelAndView addRestaurant(@ModelAttribute("restaurantForm") Restaurant r, ModelMap model, BindingResult result) {
			try {
				RestaurantDAO.createRestaurant(r);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return new ModelAndView("redirect:/listRestaurante.htm");
		}

		// Update
		@RequestMapping(value = "editare-restaurant.htm", method = RequestMethod.GET)
		public ModelAndView showEditRestaurant(@RequestParam Integer id, Model model) throws SQLException {
			Restaurant r = RestaurantDAO.getRestaurantById(id);
			model.addAttribute("restaurantForm", r);

			return new ModelAndView("Restaurant/edit.jsp", "model", model);
		}

		@RequestMapping(value = "editare-restaurant-save.htm", method = RequestMethod.POST)
		public ModelAndView editRestaurant(@ModelAttribute("restaurantForm") Restaurant r, ModelMap model, BindingResult result) {
			try {
				RestaurantDAO.updateRestaurant(r);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return new ModelAndView("redirect:/listRestaurante.htm");
		}

		// Delete
		@RequestMapping(value = "deleteRestaurant.htm", method = RequestMethod.GET)
		public ModelAndView deleteRestaurant(@RequestParam Integer id) throws SQLException {
			RestaurantDAO.deleteRestaurant(id);

			return new ModelAndView("redirect:/listRestaurante.htm");
		}
	
}
