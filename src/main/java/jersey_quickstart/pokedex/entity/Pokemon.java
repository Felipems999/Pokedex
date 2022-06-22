package jersey_quickstart.pokedex.entity;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Pokemon {
	@JsonIgnoreProperties(ignoreUnknown = true)
	private int id;
	private String num;
	private String name;
	private String img;
	private List<String> type;
	private String height;
	private String weight;
	private String candy;
	private String candy_count;
	private String egg;
	private float spawn_chance;
	private int avg_spawns;
	private String spawn_time;
	private List<Float> multipliers;
	private List<String> weaknesses;
	private List<HashMap<String, String>> next_evolution;
	private List<HashMap<String, String>> pre_evolution;

	public Pokemon() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getCandy() {
		return candy;
	}

	public void setCandy(String candy) {
		this.candy = candy;
	}

	public String getCandy_count() {
		return candy_count;
	}

	public void setCandy_count(String candy_count) {
		this.candy_count = candy_count;
	}

	public String getEgg() {
		return egg;
	}

	public void setEgg(String egg) {
		this.egg = egg;
	}

	public float getSpawn_chance() {
		return spawn_chance;
	}

	public void setSpawn_chance(float spawn_chance) {
		this.spawn_chance = spawn_chance;
	}

	public int getAvg_spawns() {
		return avg_spawns;
	}

	public void setAvg_spawns(int avg_spawns) {
		this.avg_spawns = avg_spawns;
	}

	public String getSpawn_time() {
		return spawn_time;
	}

	public void setSpawn_time(String spawn_time) {
		this.spawn_time = spawn_time;
	}

	public List<Float> getMultipliers() {
		return multipliers;
	}

	public void setMultipliers(List<Float> multipliers) {
		this.multipliers = multipliers;
	}

	public List<String> getWeakness() {
		return weaknesses;
	}

	public void setWeakness(List<String> weakness) {
		this.weaknesses = weakness;
	}

	public List<HashMap<String, String>> getNext_evolution() {
		return next_evolution;
	}

	public void setNext_evolution(List<HashMap<String, String>> next_evolution) {
		this.next_evolution = next_evolution;
	}

	public List<HashMap<String, String>> getPre_evolution() {
		return pre_evolution;
	}

	public void setPre_evolution(List<HashMap<String, String>> pre_evolution) {
		this.pre_evolution = pre_evolution;
	}
}
