package com.project.hospitalreservation.controller;

import com.project.hospitalreservation.service.UserService;
import com.project.hospitalreservation.RbsService;
import com.project.hospitalreservation.dto.CustomUserDetails;
import com.project.hospitalreservation.vo.UserSessionVo;


import com.project.hospitalreservation.doctor;
import com.project.hospitalreservation.Room;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
@Log4j2
public class MainController {
	@Autowired
    private UserService userservice;
	@Autowired
	private RbsService RbsService;
    @GetMapping(value = {"/home", "/"})
    public String goHome() {
        return "content/home";
    }

    @GetMapping(value = "/login")
    public String getLogin(Model model, @RequestParam(name = "fail", required = false) boolean fail,
                           @RequestParam(name = "new_user", required = false) boolean newUser) {
        log.info("Received /login Request");

        log.info("FAIL STATUS: " + fail);
        model.addAttribute("fail", fail);
        log.info("newUser STATUS: " + newUser);
        model.addAttribute("newUser", newUser);

        return "/content/login";
    }

    @GetMapping(value = "/check_security")
    public String getSecurity(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        final UserSessionVo userSessionVo = new UserSessionVo(customUserDetails.getUserEntity());
        log.info("userSessionVo: " + userSessionVo);
        return "content/home";
    }
    @GetMapping(value = "/about")
    public String about() {
    	return "/content/about";
    }
    @GetMapping(value = "/department")
    public String department() {
    	return "/content/department";
    }
    @GetMapping(value="/reservation")
    public String reservation() {
    	return "/content/reservation";
    }

    @GetMapping(path="/reserv")
	public String ReservForm() {
		return "/Reservation";
	}
    
	/*@RequestMapping(value = "/showReservationForm", method = RequestMethod.GET)
	public String showFormForAdd(Model model) {
		model.addAttribute("room", new Room());
		return "Rsb-form";
	}*/
	@RequestMapping(value = "/showPlaceSetForm", method = RequestMethod.GET)
	public String showFormForHotelSetup(Model model) {
		model.addAttribute("place", new doctor());
		return "Place-setup-form";
	}
	@RequestMapping(value = "/makeplace", method = RequestMethod.POST)
	public String makePlace(@ModelAttribute doctor place) {
		return RbsService.makePlace(place);
	}
	@RequestMapping(value = "/showUpdateForm/{id}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Long id, Model model){
		return RbsService.showUpdateForm(id, model);
	}
	@RequestMapping(value = "/addReserv", method = RequestMethod.POST)
	public String addReserv(@ModelAttribute Room room) {
		return RbsService.addReserv(room);
	}
	@RequestMapping(value = "/deleteBooking/{id}", method = RequestMethod.GET)
	public String deleteBooking(@PathVariable("id") Long id, Model model){
		return RbsService.deleteReserv(id, model);
	}
	@RequestMapping("/showall")
	public String showAll(Model model) {
		return RbsService.showAll(model);
	}
	@RequestMapping("/showalloccupied")
	public String showAllOccupied(Model model) {
		return RbsService.showAllOccupied(model);
	}
	

	@RequestMapping("/showavailable")
	public String showAvailableRooms(Model model) {
		return RbsService.showAvailableRooms(model);
	}
   
}
