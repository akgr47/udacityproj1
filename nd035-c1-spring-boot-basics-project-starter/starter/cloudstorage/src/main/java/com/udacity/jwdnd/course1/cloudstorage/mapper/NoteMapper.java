package com.udacity.jwdnd.course1.cloudstorage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;

@Mapper
public interface NoteMapper {
	@Select("SELECT * FROM NOTES WHERE userid = #{userId}")
	@Results({
		@Result(column = "notetitle", property = "title"),
		@Result(column = "notedescription", property = "description")
	})
	List<Note> findNotes(final Integer userId);
	
	@Insert("INSERT INTO NOTES(notetitle, notedescription, userid) " + 
	        "VALUES(#{title}, #{description}, #{userId})")
	@Options(useGeneratedKeys = true, keyProperty = "noteId")
	int createNote(Note note);
	
	@Update("UPDATE NOTES SET notetitle = #{title}, notedescription = #{description} " + 
	        "WHERE noteid = #{noteId}")
	void updateNote(Note note);
}
