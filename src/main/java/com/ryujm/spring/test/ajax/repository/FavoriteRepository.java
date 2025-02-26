package com.ryujm.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ryujm.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {

	public int insertFavorite(@Param("name") String name
							,@Param("url") String url);
	
	public List<Favorite> getfavorite(Favorite favorite);
	
	// 중복확인용 행 개수 조회
	public int selectCountByUrl(@Param("url") String url);
	
	// 삭제기능을 위한 id 를 가지고 해당 행 조회
	public int deleteColumn(@Param("id") int id);
}
