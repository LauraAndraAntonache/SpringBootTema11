package ro.digitalnation.jpa;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Controller
public class TrackController {

	@Autowired
	private ExplorerRepository explorerRepository;
	@Autowired
	private TrainerRepository trainerRepository;
	@Autowired
	private CursRepository cursRepository;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/exploreri")
	public String explorers(Model model) {
		model.addAttribute("exploreri", explorerRepository.findAll());
		return "exploreri";
	}

	@GetMapping("/addExplorer")
	public String addExplorer(Model model) {
		model.addAttribute("explorer", new Explorer());
		return "addExplorer";

	}
	
	@PostMapping("/createExplorer")
	public String createExplorer(@ModelAttribute Explorer explorer, Model model) {
		model.addAttribute("explorer", explorer);
		explorerRepository.save(explorer);
		return "redirect:exploreri";
	}

	@GetMapping("/explorer/{id}")
	public Optional<Explorer> explorer(@PathVariable Long id) {
		return explorerRepository.findById(id);
	}

	
	@GetMapping("/traineri")
	public ArrayList<Persoana> trainesr() {
		ArrayList<Persoana> trList = new ArrayList<Persoana>();
		Iterable<Trainer> findAll = trainerRepository.findAll();
		for(Trainer t: findAll) {
			trList.add(t);
		}
		return trList;
	}

	@PostMapping("/addTrainer")
	public void createTrainer(@RequestBody Trainer trainer) {
		trainerRepository.save(trainer);
	}

	@GetMapping("/cursuri")
	public ArrayList<Curs> cursuri() {
		ArrayList<Curs> trList = new ArrayList<Curs>();
		Iterable<Curs> findAll = cursRepository.findAll();
		for(Curs t: findAll) {
			trList.add(t);
		}
		return trList;
	}

	@PostMapping("/addCurs")
	public void createCurs(@RequestBody Curs curs) {
		cursRepository.save(curs);
	}
}