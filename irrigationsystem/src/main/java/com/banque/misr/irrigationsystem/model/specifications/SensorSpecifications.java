package com.banque.misr.irrigationsystem.model.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.banque.misr.irrigationsystem.entity.SensorEntity;
import com.banque.misr.irrigationsystem.entity.SensorEntity_;
import com.banque.misr.irrigationsystem.enums.Status;

public final class SensorSpecifications {

	private SensorSpecifications() {}
	
	public static Specification<SensorEntity> hasName(String name) {
		return (root, query, cb) -> {
			String containsLikePattern = getContainsLikePattern(name);
			return cb.like(cb.lower(root.<String>get(SensorEntity_.name)), containsLikePattern.toLowerCase());
        };
	}

	public static Specification<SensorEntity> hasDescription(String description) {
		return (root, query, cb) -> {
			String containsLikePattern = getContainsLikePattern(description);
			return cb.like(cb.lower(root.<String>get(SensorEntity_.description)), containsLikePattern.toLowerCase());
        };
	}
	
	public static Specification<SensorEntity> isActive() {
		return (root, query, cb) -> cb.equal(root.<Boolean>get(SensorEntity_.active), true);
	}
	
	public static Specification<SensorEntity> hasStatus(String status) {
		return (root, query, cb) -> cb.equal(root.<Status>get(SensorEntity_.status), Status.fromValue(status.toUpperCase()));
	}
	
	private static String getContainsLikePattern(String searchText) {
		if (searchText == null || searchText.isEmpty()) {
            return "%";
        }
        else {
            return "%" + searchText.toLowerCase() + "%";
        }
	}
}
