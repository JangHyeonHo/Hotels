package com.hotels.peregrine.service.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.peregrine.model.RoomDTO;
import com.hotels.peregrine.other.AutoFileClassfication;
import com.hotels.peregrine.other.ClassifiedFile;
import com.hotels.peregrine.repository.RoomRepository;
 
@Service
public class RoomsService {

	@Autowired
	private RoomRepository room;


	public int action(RoomDTO rooms, HttpServletRequest request) {
		if(!rooms.getRoomImage().isEmpty()) {
			ClassifiedFile fileNaming = AutoFileClassfication.OnefileClassficationing(rooms.getRoomImage(), request.getSession().getServletContext().getRealPath("/") + "/resources/img/front/rooms/");
			rooms.setRoomStoreFileName(fileNaming.getFileStoreName());
		}
		
		return room.insert(rooms);
		
	}
	
	
}
