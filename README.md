Awards App
Description:
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

URI: /awards/dashboard
- will return the total reward points + the reward points earned by each customer per month

uri: /awards/
- will return all the transactions made

uri: /awards/month/3
- will return the transactions for the specfic month value passed

uri: /awards/Jackson/month/3
- will return the transactions for customer "Jackson" for the month - 3 
