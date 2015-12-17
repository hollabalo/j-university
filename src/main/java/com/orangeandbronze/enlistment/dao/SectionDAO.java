package com.orangeandbronze.enlistment.dao;

import com.orangeandbronze.enlistment.domain.Section;

public interface SectionDAO {
	Section findBySectionId(String sectionId);
	void save(Section section);
}
