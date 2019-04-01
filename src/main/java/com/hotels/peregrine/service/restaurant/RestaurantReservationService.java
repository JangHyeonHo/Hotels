package com.hotels.peregrine.service.restaurant;

import java.util.ArrayList;
import java.util.Date;
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

	public boolean mainaction(RestaurantReservationDTO dto) {
		List<RestaurantChairCommand> chairList = reRepository.AllChairs(dto.getRestaurant().getResName(),dto.getRrDate());
		List<RestaurantReservationDTO> resList = new ArrayList<RestaurantReservationDTO>();
		int people = dto.getRrAdult() + dto.getRrChild(); //10
		for(int i = 0; i< chairList.size(); i++) {
			if(people == 0) {
				break;
			}
			int maxChair = chairList.get(i).getResChair(); //6
			int Tablecount = chairList.get(i).getResTableCount();// 10
			while(Tablecount > 0) {
				if(people-maxChair >= 0 || chairList.size() ==1) { //21-6
					people -= maxChair; //15;
					Tablecount--;
					if(people <= 0) {
						people = 0;
					}
				} else if(people-maxChair < 0) { //4-6
					int finalChair = 0;
					for(int b = i; b<chairList.size()-1; b++) {
						int chairMoving = chairList.get(b).getResChair()-people; //4-1 ==3
						int secoundMoving = chairList.get(b+1).getResChair()-people; //2-1 ==1
						if(chairMoving>secoundMoving && secoundMoving < 0) {
							finalChair = chairList.get(b).getResChair();
							people = 0;
							break;
						} else if(chairMoving>secoundMoving && secoundMoving == 0) {
							finalChair = chairList.get(b+1).getResChair();
							people = 0;
							break;
						} else if(b==chairList.size()-2 && secoundMoving > 0) {
							int num=0;
							int finalcnt = 0;
							
							do {
								num++;
								finalcnt = chairList.get(chairList.size()-num).getResTableCount();
							} while(finalcnt<=0);
							finalChair = chairList.get(chairList.size()-num).getResChair();
							people = 0;
							break;
						}
					}
					if(chairList.size() !=1) {
						maxChair = finalChair;
					} 
				}
				System.out.println("배치 의자 : " + maxChair);
				resList.add(new RestaurantReservationDTO() 
						.setCustomer(dto.getCustomer())
						.setRestaurant(new RestaurantDTO().setResName(dto.getRestaurant().getResName()).setResChair(maxChair))
						.setRrAdult(dto.getRrAdult())
						.setRrChild(dto.getRrChild())
						.setRrDate(dto.getRrDate()));
						
						
				if(people==0) {
					break;
				}			
			}
		}
		if(people > 0) {
			return false;
		} else {
			reRepository.resinsert(resList);
			return true;
		}
		
	}


	public RestaurantCommand resTableSearch(String resName,String dateTime) {

		return	reRepository.resname(resName,dateTime);
	}
}
