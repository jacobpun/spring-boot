package org.pk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreService {
	@Autowired
	private StoreRepository repo;
	@RequestMapping("/stores")
	public GeoResults<Store> search(
			@RequestParam double fromLatitude,
			@RequestParam double fromLongitude,
			@RequestParam double distance,
			@RequestParam Metrics distanceUnits) {
		return repo.findByLocationNear(new Point(fromLatitude, fromLongitude), 
				new Distance(distance, distanceUnits));
	}
}