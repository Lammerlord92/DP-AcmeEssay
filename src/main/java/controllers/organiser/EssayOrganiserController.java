package controllers.organiser;

import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ContestService;
import services.EssayService;

import controllers.AbstractController;
import domain.Contest;
import domain.Essay;

@Controller
@RequestMapping("essay/organiser")
public class EssayOrganiserController extends AbstractController{
	
	// ----------------------- Managed service -----------------------
	@Autowired
	private EssayService essayService;
	@Autowired
	private ContestService contestService;
	// ------------------------- Constructor -------------------------
	
	// -------------------------   UseCases  -------------------------
	
	@RequestMapping(value= "/publish", method = RequestMethod.GET)
	public ModelAndView details(@RequestParam int essayId){
		ModelAndView result;
		
		try{
			essayService.publish(essayId);
			result= new ModelAndView("redirect:/contest/organiser/list.do");
		}catch(Throwable oops){
			result= new ModelAndView("redirect:/contest/organiser/list.do");
			result.addObject("message", "lodge.commit.error");
		}
		return result;
	}
	
	@RequestMapping(value= "/listAll", method = RequestMethod.GET)
	public ModelAndView listAllEssays(@RequestParam int contestId){
		ModelAndView result;
		Boolean isPublishable=false;
	    Collection<Essay> essays=essayService.submittedEssaysByContestOrganiser(contestId);
	    System.out.println(essays);
	    String requestURI="essay/organiser/listAll.do";
	    
	    Contest c=contestService.findOne(contestId);
	    if(c.getHoldingDate().before(new Date())){
	    	isPublishable=true;
	    }
	    
	    result = new ModelAndView("essay/organiser/listAll");
	    result.addObject("essays",essays);
	    result.addObject("isPublishable",isPublishable);
	    result.addObject("requestURI",requestURI);
		return result;
	}
	// ---------------------- Ancillary methods ----------------------
}