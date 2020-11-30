insert into public.dealer (dealerid, name) values (100, 'American Freight');
insert into public.dealer (dealerid, name) values (200, 'Ashley Furniture');
insert into public.dealer (dealerid, name) values (300, 'Walmart');

insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (1, 'Frank', 'Zappa', '123 Main St', '', 'Anytown', 23, '12345');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (2, 'Fred', 'Frith', '124 Main St', '', 'Anytown', 24, '12346');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (3, 'Brian', 'Eno', '125 Main St', '', 'Anytown', 25, '12347');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (4, 'Morton', 'Feldman', '126 Main St', '', 'Anytown', 26, '12348');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (5, 'John', 'Cage', '127 Main St', '', 'Anytown', 27, '12349');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (6, 'Gyorgy', 'Ligeti', '128 Main St', '', 'Anytown', 28, '12350');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (7, 'Iannis', 'Xenakis', '129 Main St', '', 'Anytown', 29, '12351');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (8, 'Miles', 'Davis', '130 Main St', '', 'Anytown', 30, '12352');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (9, 'Cecil', 'Taylor', '131 Main St', '', 'Anytown', 31, '12353');
insert into public.customer (customerid, firstname, lastname, street1, street2, city, state, zip) values (10, 'Robert', 'Fripp', '132 Main St', '', 'Anytown', 32, '12354');

insert into public.account (accountnumber, balance, currencycode, interestrate, originalprincipal, paymentduedayofmonth, dealer_dealerid) values ('4567', 100.0, 'USD', 0.08, 1000.0, 15, 100);
insert into public.account (accountnumber, balance, currencycode, interestrate, originalprincipal, paymentduedayofmonth, dealer_dealerid) values ('4568', 227.59, 'USD', 0.09, 8000.0, 30, 100);
insert into public.account (accountnumber, balance, currencycode, interestrate, originalprincipal, paymentduedayofmonth, dealer_dealerid) values ('4569', 4569.87, 'USD', 0.05375, 10000.0, 1, 200);
insert into public.account (accountnumber, balance, currencycode, interestrate, originalprincipal, paymentduedayofmonth, dealer_dealerid) values ('4570', 39.85, 'USD', 0.29, 150.0, 23, 200);
insert into public.account (accountnumber, balance, currencycode, interestrate, originalprincipal, paymentduedayofmonth, dealer_dealerid) values ('4571', 500.0, 'USD', 0.25, 2000.0, 16, 300);
insert into public.account (accountnumber, balance, currencycode, interestrate, originalprincipal, paymentduedayofmonth, dealer_dealerid) values ('4572', 768.43, 'USD', 0.06, 800.0, 4, 300);
insert into public.account (accountnumber, balance, currencycode, interestrate, originalprincipal, paymentduedayofmonth, dealer_dealerid) values ('4573', 129.15, 'USD', 0.12, 900.0, 7, 300);

insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4567', 1, 1);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4567', 2, 2);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4568', 3, 3);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4568', 4, 4);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4569', 5, 5);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4570', 6, 6);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4570', 7, 7);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4571', 8, 8);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4571', 9, 9);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4571', 10, 10);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4572', 4, 4);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4572', 7, 7);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4573', 2, 2);
insert into public.account_customer(account_accountnumber, primaryaccountholders_customerid, cosigners_customerid) values ('4573', 9, 9);
