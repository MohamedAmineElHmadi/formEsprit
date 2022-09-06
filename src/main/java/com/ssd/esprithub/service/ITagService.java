package com.ssd.esprithub.service;

import java.util.List;

import com.ssd.esprithub.entity.Tag;







public interface ITagService {
	Tag addTag (Tag q);
	List<Tag> retrieveTags();

	

	void deleteTag(Long id);

	Tag updateTag(Tag u);

	Tag retrieveTag(Long id);

}
