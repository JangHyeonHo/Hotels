package com.hotels.peregrine.service.fb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	public int registFood(FoodDTO food, MultipartFile foodImage, HttpServletRequest request, int[] materialNo) {
		// TODO Auto-generated method stub
		if(!foodImage.isEmpty()) {
			ClassifiedFile fileNaming = AutoFileClassfication.OnefileClassficationing(foodImage, request.getSession().getServletContext().getRealPath("/") + "/fb/food/");
			food.setFoodOriFileName(fileNaming.getFileOriginName())
			.setFoodStoreFileName(fileNaming.getFileStoreName());
		}
		food.setFoodRegist(FoodDTO.FOODREGISTKIND[1]);
		AutoTest.ModelBlackTest(food);
		int result = foodRepository.regist(food);
		if(result == 0) {
			return 0;
		} else {
			int foodNo = foodRepository.searchNo(food);
			return rfRepository.insertRecipe(foodNo, materialNo);
		}
	}

}
