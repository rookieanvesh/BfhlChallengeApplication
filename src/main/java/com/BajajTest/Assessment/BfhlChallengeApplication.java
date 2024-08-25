package com.BajajTest.Assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
public class BfhlChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BfhlChallengeApplication.class, args);
	}

	@PostMapping
	public ResponseDTO handlePostRequest(@RequestBody RequestDTO request) {
		ResponseDTO response = new ResponseDTO();
		response.setIs_success(true);
		response.setUser_id("Anvesh_Srivastava_18022003"); // Replace with your actual user_id
		response.setEmail("anvesh.kumar2021@vitbhopal.ac.in"); // Replace with your actual email
		response.setRoll_number("21BCE10945"); // Replace with your actual roll number

		List<String> numbers = new ArrayList<>();
		List<String> alphabets = new ArrayList<>();

		for (String item : request.getData()) {
			if (item.matches("\\d+")) {
				numbers.add(item);
			} else if (item.matches("[a-zA-Z]")) {
				alphabets.add(item);
			}
		}

		response.setNumbers(numbers);
		response.setAlphabets(alphabets);

		String highestLowercase = alphabets.stream()
				.filter(s -> s.matches("[a-z]"))
				.max(String::compareTo)
				.orElse(null);

		response.setHighest_lowercase_alphabet(highestLowercase != null ? List.of(highestLowercase) : List.of());

		return response;
	}

	@GetMapping
	public OperationCodeDTO handleGetRequest() {
		return new OperationCodeDTO(1);
	}
}

class RequestDTO {
	private List<String> data;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}

class ResponseDTO {
	private boolean is_success;
	private String user_id;
	private String email;
	private String roll_number;
	private List<String> numbers;
	private List<String> alphabets;
	private List<String> highest_lowercase_alphabet;

	public boolean isIs_success() {
		return is_success;
	}

	public void setIs_success(boolean is_success) {
		this.is_success = is_success;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(String roll_number) {
		this.roll_number = roll_number;
	}

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	public List<String> getAlphabets() {
		return alphabets;
	}

	public void setAlphabets(List<String> alphabets) {
		this.alphabets = alphabets;
	}

	public List<String> getHighest_lowercase_alphabet() {
		return highest_lowercase_alphabet;
	}

	public void setHighest_lowercase_alphabet(List<String> highest_lowercase_alphabet) {
		this.highest_lowercase_alphabet = highest_lowercase_alphabet;
	}
}

class OperationCodeDTO {
	private int operation_code;

	public OperationCodeDTO(int operation_code) {
		this.operation_code = operation_code;
	}

	public int getOperation_code() {
		return operation_code;
	}

	public void setOperation_code(int operation_code) {
		this.operation_code = operation_code;
	}
}