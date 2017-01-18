package controllers.administrator;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Author;
import domain.Contest;

import services.AuthorService;
import services.ContestService;
import services.EssayService;

@Controller
@RequestMapping("/administrator")
public class DashboardAdministratorController {
	//Services-----------------------
	@Autowired
	private ContestService contestService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private EssayService essayService;
	//Listing------------------------
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public ModelAndView dashboard(){
		ModelAndView result;
		//A
		Collection<Contest> contestDesc;
		contestDesc=contestService.orderByNumberOfEssaysSubmittedDesc();
		Collection<Author> authorsMoreEssSubmit;
		authorsMoreEssSubmit=authorService.authorsMoreEssaysSubmitted();
		Collection<Author> authorsMoreEssPublished;
		authorsMoreEssPublished=authorService.authorsMoreEssaysPublished();
		Collection<Author> authorsLessEssPublished;
		authorsLessEssPublished=authorService.authorsLessEssaysPublished();
		Collection<Object[]> avgNumberEssaysSubmitted ;
		avgNumberEssaysSubmitted =essayService.avgNumberEssaysSubmittedByAuthorId();
		Collection<Object[]> avgContestOrganisedByOrganiser;
		avgContestOrganisedByOrganiser = contestService.avgContestOrganisedByOrganiser();
		Collection<Contest> contestsHeldLastMonth = contestService.contestsHeldLastMonth();

		result=new ModelAndView("administrator/dashboard");
		
		//A
		result.addObject("contestDesc", contestDesc);
		result.addObject("authorsMoreEssSubmit", authorsMoreEssSubmit);
		result.addObject("authorsMoreEssPublished", authorsMoreEssPublished);
		result.addObject("authorsLessEssPublished", authorsLessEssPublished);
		result.addObject("avgNumberEssaysSubmitted", avgNumberEssaysSubmitted);
		result.addObject("avgContestOrganisedByOrganiser", avgContestOrganisedByOrganiser);
		result.addObject("contestsHeldLastMonth", contestsHeldLastMonth);
		return result;
	}
}
