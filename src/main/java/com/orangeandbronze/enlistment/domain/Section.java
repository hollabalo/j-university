package com.orangeandbronze.enlistment.domain;

import static org.apache.commons.lang3.Validate.*;

import java.util.Collection;

public class Section {

	private final String sectionId;
	private Schedule schedule;
	private Room room;
	private Integer enrollees = 0;
	private Subject subject;
	private Semester semester;
	
	public Section(String sectionId, Schedule schedule, Room room, Subject subject, Semester semester) {
		notBlank(sectionId);
		notNull(schedule);
		notNull(room);
		notNull(semester);
		if(!sectionId.matches("[-\\p{Alnum}]+")) {
			throw new IllegalArgumentException("sectionId is not alphanumeric");
		}
		this.sectionId = sectionId;
		this.schedule = schedule;
		this.room = room;
		this.subject = subject;
		this.semester = semester;
		
		semester.add(this);
	}
	
	public String getSectionId() {
		return sectionId;
	}
	
	Schedule getSchedule() {
		return schedule;
	}
	
	Subject getSubject() {
		return subject;
	}
	
	public void checkForConflict(Section newSection) {
		if(schedule.equals(newSection.getSchedule())) {
			throw new ScheduleConflictException("Schedule already existing. " + newSection);
		}
		if(subject.equals(newSection.getSubject())) {
			throw new SubjectConflictException("Subject " + subject + " for already existing.");
		}
		if(sectionId.equals(newSection.getSectionId())) {
			throw new SectionIdAlreadyExistingException("Section ID already existing. " + newSection);
		}
	}
	
	public void allocateRoomSeat() {
		synchronized (enrollees) {
			if (enrollees + 1 > room.getCapacity()) {
				throw new RoomCapacityFullException("The room " + room + " is full.");
			}
			enrollees++;
		}
	}
	
	public void validatePreReq(Collection<Section> sections) {
		boolean validate = false;
		if (this.getSubject().getPreReq() != null) {
			for(Section prevSec : sections) {
				if (this.getSubject().getPreReq().equals(prevSec.getSubject())) {
					validate = true;
				}
			}
			
			if (!validate) {
				throw new PrerequisiteSubjectException("With pre-req" + this.getSubject().getPreReq());
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (sectionId == null) {
			if (other.sectionId != null)
				return false;
		} else if (!sectionId.equals(other.sectionId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return sectionId;
	}
}
