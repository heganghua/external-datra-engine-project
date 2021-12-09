local userid = KEYS[1];
local prodid = KEYS[2];

local qtkey = "sk:"..prodid..":qt";
local userskey = "sk:"..userid.."user";

local userExists = redis.call("sismember", userskey, userid);
if userExists == true then
	if tonumber(userExists) == 1 then
		return 2;
	end
end

local num = redis.call("get",qtkey);
if tonumber(num) <= 0 then
	return 0;
else
	redis.call("decr", qtkey);
	redis.call("sadd", userskey, userid);
end

return 1;