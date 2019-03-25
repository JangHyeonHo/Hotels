package com.hotels.peregrine.service.fb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.command.FoodRegistCommand;
import com.hotels.peregrine.model.FoodDTO;
import com.hotels.peregrine.other.AutoFileClassfication;
import com.hotels.peregrine.other.AutoTest;
import com.hotels.peregrine.other.ClassifiedFile;
import com.hotels.peregrine.repository.FoodRepository;
import com.hotels.peregrine.repository.RecipeFoodRepository;

@Service
public class FoodRegistService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private RecipeFoodRepository rfRepository;

	public int registFood(FoodRegistCommand command, HttpServletRequest request) {
		// TODO Auto-generated method stub
		if(!command.getFoodImage().isEmpty()) {
			ClassifiedFile fileNaming = AutoFileClassfication.OnefileClassficationing(command.getFoodImage(), request.getSession().getServletContext().getRealPath("/") + "/resources/img/fb/food/");
			command.getFood().setFoodOriFileName(fileNaming.getFileOriginName())
			.setFoodStoreFileName(fileNaming.getFileStoreName());
		}
		command.getFood().setFoodRegist(FoodDTO.FOODREGISTKIND[1]);
		AutoTest.ModelBlackTest(command.getFood());
		int result = foodRepository.regist(command.getFood());
		if(result == 0) {
			return 0;
		} else {
			int foodNo = foodRepository.searchNo(command.getFood());
			return rfRepository.insertRecipe(foodNo, command.getMaterialNo());
		}
	}

}
