package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import TDA.BTweet;
import TDA.Tweets;
import logic.Query;


@Controller
public class MainController {
		
		String b;
		List<Tweets> todoTweets;
		
	
	  @GetMapping("/")
	  public String queryForm(Model model) {
		Query query = new Query();
		  
		model.addAttribute("query", query);
		
	    return "query";
	  }
	  
	  @PostMapping("/result")
	  public String querySubmit(@ModelAttribute("query") Query query, Model model) {
		     
			int count = query.getCount();
			String content = query.getContent(); 
			b = query.getContent();
			
			todoTweets = BTweet.getTweets(count,content); 
			System.out.println("Su query: "+content); 
			
			List<Tweets> objectList = new ArrayList<Tweets>(todoTweets);
		    System.out.println(objectList);
			
		    model.addAttribute("listadotweets", objectList);
			return "result";
		}
	  
	  
		@GetMapping("/graph")
		public String getPieChart(Model model) {
			
			List<Tweets> LOanalisis = new ArrayList<Tweets>(todoTweets);
			 
			String[] Sen = {"Muy Negativo", "Negativo","Neutral","Positivo", "Muy Positivo"};
			
	  	    int mn = 0;
	  	    int m = 0;
	  	    int n = 0;
	  	    int p = 0;
	  	    int mp = 0;
	  	    
	  	    int total = todoTweets.size();;
	  	    
	  	    for (int i=0;i<total;i++) {
	  	    	
	  	    Tweets tweet =	LOanalisis.get(i);
	  	    
	  	    String sent = tweet.getSentimiento();
	  	    
			if (sent==Sen[0]) {
				mn++;
			}
			if (sent==Sen[1]) {
				m++;
			}
			if (sent==Sen[2]) {
				n++;
			}
			if (sent==Sen[3]) {
				p++;
			}
			if (sent==Sen[4]) {
				mp++;
			}
	  	    
	  	    }
	  	    
			System.out.println("Prueba"+Sen[0]+"Total :"+total+" Muy Negativo :"+mn+"Negativo :"
			+m+" Neutral :"+n+" Positivo :"+p+" Muy Positivo :"+mp);
		  	
			
			Map<String, Integer> graphData = new TreeMap<>();
			graphData.put("Muy Negativo", mn);
			graphData.put("Negativo", m);
			graphData.put("Neutral", n);
			graphData.put("Positivo", p);
			graphData.put("Muy Positivo", mp);
			model.addAttribute("query",b);
			model.addAttribute("chartData", graphData);
			return "graph";
		}

	  
}
