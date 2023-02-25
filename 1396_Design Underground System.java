class UndergroundSystem {
    Map<Integer, Customer> customerMap;
    Map<String, Route> routeMap;

    public UndergroundSystem() {
        this.customerMap = new HashMap<>();
        this.routeMap = new HashMap<>();     
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(!customerMap.containsKey(id)) {
            Customer customer = new Customer(t, stationName);
            customerMap.put(id, customer);
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(customerMap.containsKey(id)) {
            Customer customer = customerMap.get(id);
            customer.checkOut(t, stationName);
            String key = customer.inStation + "+" + customer.outStation;
            Route route = routeMap.getOrDefault(key, new Route(customer.inStation, customer.outStation));
            route.addTrip(customer.inTime, customer.outTime);
            routeMap.put(key, route);
            customerMap.remove(id);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "+" + endStation;
        Route route = routeMap.get(key);
        return route.getAverage();
    }

    class Customer {
        int inTime, outTime;
        String inStation, outStation;

        public Customer(int inTime, String inStation) {
            this.inTime = inTime;
            this.inStation = inStation;
        }

        public void checkOut(int outTime, String outStation) {
            this.outTime = outTime;
            this.outStation = outStation;
        }
    }

    class Route {
        String start, end;
        int totalTime, totalTrips;

        public Route(String start, String end) {
            this.totalTime = 0;
            this.totalTrips = 0;
            this.start = start;
            this.end = end;
        }

        public void addTrip(int startTime, int endTime) {
            this.totalTime += endTime - startTime;
            this.totalTrips++;
        }

        public double getAverage() {
            return (double)totalTime / totalTrips;
        }
    }
}
