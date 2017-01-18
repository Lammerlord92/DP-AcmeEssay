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

import controllers.AbstractController;
import domain.Contest;
@Controller
@RequestMapping("/contest/organiser")
public class ContestOrganiserController extends AbstractController {
	//Services --------------------------------------------------
	@Autowired
	private ContestService contestService;
	
	//Listing------------------------
	@RequestMapping("/list")
	public ModelAndView listAll() {
		ModelAndView result;
		
		Collection<Contest> contests;
		
		contests=contestService.findByOrganiser();
		String requestURI="contest/organiser/list.do";
			
		result = new ModelAndView("contest/organiser/list");
		result.addObject("contests",contests);
		result.addObject("requestURI",requestURI);
		return result;
	}
	
	//Deleting------------------------
	@RequestMapping(value="/edit",method=RequestMethod.POST,params="delete")		
	public ModelAndView delete(Contest contest, BindingResult binding){
		ModelAndView result;
		try{
			contestService.delete(contest);
			result=new ModelAndView("redirect:list.do");
		} catch(Throwable oops){
			result=createEditModelAndView(contest,"contest.commit.error");
		}
		return result;
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST,params="save")		
	public ModelAndView save(@Valid Contest contest, BindingResult binding){
		ModelAndView result;
		
		if(binding.hasErrors()){
			result=createEditModelAndView(contest);
		} else{
			try{
				contestService.save(contest);
				result=new ModelAndView("redirect:list.do");
			} catch(Throwable oops){
				result=createEditModelAndView(contest,"request.commit.error");
			}
		}
		return result;
	}
	@RequestMapping(value="/create",method=RequestMethod.POST,params="saveCreate")		
	public ModelAndView saveCreate(@Valid Contest contest, BindingResult binding){
		ModelAndView result;
		
		if(binding.hasErrors()){
			result=createEditModelAndView(contest);
		} else{
			try{
				contestService.saveCreate(contest);
				result=new ModelAndView("redirect:list.do");
			} catch(Throwable oops){
				result=createEditModelAndView(contest,"request.commit.error");
			}
		}
		return result;
	}
	//	Edition ---------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int contestId){
		ModelAndView result;
		Contest contest;
		
		contest = contestService.findOne(contestId);
		Assert.notNull(contest);
		result = createEditModelAndView(contest);
		
		return result;
	}
	
	
	//Creation----------------------
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView result;
		Contest contest;
		
		contest = contestService.create();
		Assert.notNull(contest);
		result = createEditModelAndViewCreate(contest);
		
		return result;
		
	}
	
	// Ancillary methods
	protected ModelAndView createEditModelAndView(Contest contest){
		ModelAndView result;
		result=createEditModelAndView(contest,null);		
		return result;
	}
	
	protected ModelAndView createEditModelAndView(Contest contest, String message){
		ModelAndView result;
		Boolean borrable=false;
		Boolean resoluble=false;
		if(contest.getEssays().size()==0){
			borrable=true;
		}
		if(contest.getResult()==null || contest.getResult().equals("")){
			Date todayDate=new Date();
			if(todayDate.after(contest.getHoldingDate())){
				resoluble=true;
			}
		}
		
		result=new ModelAndView("contest/organiser/edit");
		result.addObject("contest", contest);
		result.addObject("borrable", borrable);
		result.addObject("resoluble", resoluble);
		return result;
	}
	
	
	
	protected ModelAndView createEditModelAndViewCreate(Contest contest){
		ModelAndView result;
		
		result = createEditModelAndViewCreate(contest, null);
		return result;
	}
	
	protected ModelAndView createEditModelAndViewCreate(Contest contest, String message){
		ModelAndView result;
		
		result = new ModelAndView("contest/organiser/create");
		result.addObject("contest",contest);
		result.addObject("message",message);
	
		return result;
	}
}
