package com.hotels.peregrine.service.restaurant;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.RestaurantChairCommand;
import com.hotels.peregrine.command.RestaurantCommand;
import com.hotels.peregrine.model.CustomerDTO;
import com.hotels.peregrine.model.RestaurantDTO;
import com.hotels.peregrine.model.RestaurantReservationDTO;
import com.hotels.peregrine.repository.CustomerRepository;
import com.hotels.peregrine.repository.RestaurantRepository;

@Service
public class RestaurantReservationService {

	@Autowired
	private CustomerRepository cusRepository;

	@Autowired
	private RestaurantRepository reRepository;


	public RestaurantReservationDTO cusaction(RestaurantReservationDTO dto) {
		CustomerDTO customers = dto.getCustomer();
		cusRepository.insert(customers);
		dto.getCustomer().setCosNo(cusRepository.select(customers));
		return dto;
	}


	public List<RestaurantCommand> resname() {



		return	reRepository.resnamesearch(null);
	}

	public void mainaction(RestaurantReservationDTO dto,RestaurantChairCommand command) {
		List<RestaurantChairCommand> chairList = reRepository.AllChairs(command.getResName());
		List<RestaurantReservationDTO> resList = new ArrayList<RestaurantReservationDTO>();
		int people = dto.getRrAdult() + dto.getRrChild(); //10
		for(int i = 0; i< chairList.size(); i++) {
			if(people == 0) {
				break;
			}
			int maxChair = chairList.get(i).getResChair(); //6 4 2
			int Tablecount = chairList.get(i).getResTableCount();// 1 3 4
			while(Tablecount > 0) {
				if(people-maxChair >= 0) {
					people -= maxChair;
					Tablecount--;
				} else if(people-maxChair < 0) {
					for(int b = 0; b<chairList.size(); b++) {
						int chairMoving = chairList.get(b).getResChair()-people;
						if(people-maxChair<0) {
							maxChair = chairList.get(b-1).getResChair();
							people = 0;
							break;
						} 
					}
				}
				resList.add(new RestaurantReservationDTO()
						.setCustomer(dto.getCustomer())
						.setRestaurant(dto.getRestaurant().setResChair(maxChair))
						.setRrAdult(dto.getRrAdult())
						.setRrChild(dto.getRrChild()));
				if(people==0) {
					break;
				}
						
				
			}
		}
		reRepository.resinsert(resList);
	}


	public RestaurantCommand resTableSearch(String resName) {

		return	reRepository.resname(resName);
	}
}
