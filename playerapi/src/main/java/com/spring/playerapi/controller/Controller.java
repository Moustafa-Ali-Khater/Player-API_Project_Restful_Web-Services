package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.exception.StudentException;
import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;


@RestController
@RequestMapping("/api")
public class Controller {
	
	
	@Autowired
	private PlayerService playerService;
	
	
	@GetMapping("/data")
	public String getdata() {
		return "Hallo...";
	}
	
	@GetMapping("/players")
	public List<Player> gePlayers() {
		return playerService.allPlayers();
	}
	
	@GetMapping("/players/{id}")
	public Player getplayerById(@PathVariable("id") int id) {
		Player p = playerService.showPlayer(id);
		if(p == null) {
			throw new StudentException("Player Not Found " + "ID: " + id);
		}
		return p;
	}
	
	/*@GetMapping("/players")
	public Player getplayerId(@RequestParam int id) {
		Player p = playerService.showPlayer(id);
		if(p == null) {
			throw new StudentException("Player Not Found " + "ID: " + id);
		}
		return p;
	}*/
	
	/*@PostMapping("/saveplayer")
	public Player saveplayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return player;
	}*/
	
	@PostMapping("/saveplayer")
	public String saveplayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Add successfully!";
	}
	
	@PutMapping("/update")
	public String updateplayer(@RequestBody Player player) {
		playerService.savePlayer(player);
		return "Update successfully!";
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteplayer(@PathVariable ("id") int id) {
		int r = playerService.deletePlayer(id);
		System.out.println(r);
		if (r == 0) {
			throw new StudentException("Player Not Found " + "ID: " + id);
		}
	}
	
	/*@DeleteMapping("/delete")
	public void removeplayer(@RequestParam int id) {
		playerService.deletePlayer(id);
	}*/
	
	
	
//	@GetMapping("/players")
//	public List<Player> getPlayers(){
//		return playerService.allPlayers();
//	}
//	
//	
//	@GetMapping("/players/{id}")
//	public Player getPlayerById(@PathVariable("id")int id) {
//		Player p = playerService.showPlayer(id); //  //
//		if(p == null) {
//			throw new StudentException("Player Not Found id: " + id);
//		}
//		return p;
//	}
//	
//	/*@GetMapping("/players")
//	public Player getPlayerById(@RequestParam int id) {
//		return playerService.showPlayer(id);
//	}*/
//	
//	@PostMapping("/players")
//	public String savaPlayer(@RequestBody Player player) {
//		playerService.savePlayer(player);
//		return "Success Added";
//	}
//	
//	@PutMapping("/players")
//	public String editPlayer(@RequestBody Player player) {
//		playerService.savePlayer(player);
//		return "Success editing";
//	}
//	
//	@DeleteMapping("/players/{id}")
//	public void removePlayer(@PathVariable("id")int id) {
//		int result = playerService.deletePlayer(id);
//		System.out.println(result);
//		if(result == 0) {
//			throw new StudentException("Player Not Found id: " + id);
//		}
//			
//		
//	}
//	/*@DeleteMapping("/players")
//	public void removePlayer(@RequestParam int id) {
//		playerService.deletePlayer(id);
//	}*/
}
