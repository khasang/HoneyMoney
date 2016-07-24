package ru.khasang.honeymoney.localrepository;

import android.net.Uri;
import android.provider.BaseColumns;

public final class UserDataContractClass {
    public static final String AUTHORITY = "ru.khasang.honeymoney.localrepository.honeymoneyprovider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static class User implements BaseColumns {
        private static final String TABLE_USER_PATH = "user";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_USER_PATH);
        public static final String TABLE_USER = "tableUser";
        public static final String PHONE = "phone";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String PASSWORD = "password";
        public static final String CREATED = "created";
        public static final String[] ALL_COLUMNS =
                {_ID, PHONE, NAME, EMAIL, PASSWORD, CREATED};
    }

    public static class AccountHasUser implements BaseColumns {
        private static final String TABLE_ACCOUNT_HAS_USER_PATH = "accountHasUser";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_ACCOUNT_HAS_USER_PATH);
        public static final String TABLE_ACCOUNT_HAS_USER = "tableAccountHasUser";
        public static final String ACCOUNT_ID = "accountId";
        public static final String USER_ID = "userId";
        public static final String TYPE = "type";
        public static final String[] ALL_COLUMNS =
                {_ID, ACCOUNT_ID, USER_ID, TYPE};
    }

    public static class Account implements BaseColumns {
        private static final String TABLE_ACCOUNT_PATH = "account";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_ACCOUNT_PATH);
        public static final String TABLE_ACCOUNT = "tableAccount";
        public static final String NAME = "name";
        public static final String CREATED = "created";
        public static final String TYPE = "type";
        public static final String ALERT = "alert";
        public static final String[] ALL_COLUMNS =
                {_ID, NAME, CREATED, TYPE, ALERT};
    }

    public static class Category implements BaseColumns {
        private static final String TABLE_CATEGORY_PATH = "category";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_CATEGORY_PATH);
        public static final String TABLE_CATEGORY = "tableCategory";
        public static final String CATEGORY_ID = "categoryId";
        public static final String NAME = "name";
        public static final String[] ALL_COLUMNS =
                {_ID, CATEGORY_ID, NAME};
    }

    public static class Location implements BaseColumns {
        private static final String TABLE_LOCATION_PATH = "location";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_LOCATION_PATH);
        public static final String TABLE_LOCATION = "tableLocation";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String NAME = "name";
        public static final String[] ALL_COLUMNS =
                {_ID, LATITUDE, LONGITUDE, NAME};
    }

    public static class Currency implements BaseColumns {
        private static final String TABLE_CURRENCY_PATH = "currency";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_CURRENCY_PATH);
        public static final String TABLE_CURRENCY = "tableCurrency";
        public static final String CODE = "code";
        public static final String NAME = "name";
        public static final String[] ALL_COLUMNS =
                {_ID, CODE, NAME};
    }

    public static class Operation implements BaseColumns {
        private static final String TABLE_OPERATION_PATH = "operation";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_OPERATION_PATH);
        public static final String TABLE_OPERATION = "tableOperation";
        public static final String CURRENCY_CODE = "currencyCode";
        public static final String ACCOUNT_ID = "accountId";
        public static final String AMMOUNT = "ammount";
        public static final String TYPE = "type";
        public static final String CREATED = "created";
        public static final String LOCATION_ID = "locationId";
        public static final String CATEGORY_ID = "categoryId";
        public static final String COMMENT = "comment";
        public static final String[] ALL_COLUMNS =
                {_ID, CURRENCY_CODE, ACCOUNT_ID, AMMOUNT, TYPE, CREATED, LOCATION_ID, CATEGORY_ID, COMMENT};
    }
}
