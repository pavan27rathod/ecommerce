export default function Footer() {
  return (
    <footer className="bg-[#f7f7f7] text-[#333]">
      {/* TOP FOOTER */}
      <div className="max-w-[1440px] mx-auto px-[32px] pt-[40px] pb-[24px]">
        <div className="grid grid-cols-4 gap-[48px]">
          
          {/* Customer Service */}
          <div>
            <h3 className="text-[16px] font-medium mb-[12px]">
              Customer Service
            </h3>
            <div className="h-[1px] bg-[#cfcfcf] mb-[16px]" />

            <ul className="text-[14px] leading-[22px] space-y-[14px]">
              <li>
                Sales 1800 108 3888 (toll free) | 1800 3000 3888 (toll free)
              </li>
              <li>
                Technical 1800 108 3888 (toll free) | 1800 3000 3888 (toll free)
              </li>
              <li className="cursor-pointer hover:underline">
                Live Agent
              </li>
              <li className="cursor-pointer hover:underline">
                Submit Feedback
              </li>
              <li className="cursor-pointer hover:underline">
                FAQs
              </li>
            </ul>
          </div>

          {/* Quick Links */}
          <div>
            <h3 className="text-[16px] font-medium mb-[12px]">
              Quick Links
            </h3>
            <div className="h-[1px] bg-[#cfcfcf] mb-[16px]" />

            <ul className="text-[14px] space-y-[14px]">
              <li className="cursor-pointer hover:underline">Track my order</li>
              <li className="cursor-pointer hover:underline">Order History</li>
              <li className="cursor-pointer hover:underline">Return a Product</li>
              <li className="cursor-pointer hover:underline">Delivery Information</li>
            </ul>
          </div>

          {/* Our Company */}
          <div>
            <h3 className="text-[16px] font-medium mb-[12px]">
              Our Company
            </h3>
            <div className="h-[1px] bg-[#cfcfcf] mb-[16px]" />

            <ul className="text-[14px] space-y-[14px]">
              <li className="cursor-pointer hover:underline">About Us</li>
              <li className="cursor-pointer hover:underline">Quality Policy</li>
              <li className="cursor-pointer hover:underline">Careers</li>
              <li className="cursor-pointer hover:underline">Corporate Responsibility</li>
            </ul>
          </div>

          {/* Social Media */}
          <div>
            <h3 className="text-[16px] font-medium mb-[12px]">
              Social Media +
            </h3>
            <div className="h-[1px] bg-[#cfcfcf] mb-[16px]" />

            <div className="flex items-start gap-[16px] mb-[16px]">
              <button
                className="
                  border
                  border-[#0070c9]
                  text-[#0070c9]
                  text-[14px]
                  px-[20px]
                  py-[10px]
                  rounded-[6px]
                  font-medium
                "
              >
                Sign Up
              </button>
              <p className="text-[14px] leading-[20px]">
                Subscribe to become an exclusive element14 insider!
              </p>
            </div>

            <ul className="text-[14px] space-y-[10px]">
              <li className="flex items-center gap-[8px] cursor-pointer hover:underline">
                LinkedIn
              </li>
              <li className="flex items-center gap-[8px] cursor-pointer hover:underline">
                Twitter
              </li>
              <li className="flex items-center gap-[8px] cursor-pointer hover:underline">
                Facebook
              </li>
            </ul>
          </div>
        </div>

        {/* BADGES */}
        <div className="flex items-center justify-between mt-[40px]">
          <div className="flex items-center gap-[24px]">
            <div className="w-[90px] h-[36px] bg-[#ddd]" />
            <div className="w-[90px] h-[36px] bg-[#ddd]" />
            <div className="w-[90px] h-[36px] bg-[#ddd]" />
          </div>

          <div className="flex items-center gap-[16px]">
            <div className="w-[60px] h-[36px] bg-[#ddd]" />
            <div className="w-[60px] h-[36px] bg-[#ddd]" />
            <div className="w-[100px] h-[36px] bg-[#ddd]" />
          </div>
        </div>
      </div>

      {/* BOTTOM LEGAL */}
      <div className="border-t border-[#d6d6d6]">
        <div className="max-w-[1440px] mx-auto px-[32px] py-[20px] text-[13px] text-[#555] space-y-[10px]">
          <div className="flex flex-wrap gap-[16px]">
            <span className="cursor-pointer hover:underline">Privacy Statement</span>
            <span>|</span>
            <span className="cursor-pointer hover:underline">Legal and Copyright Notices</span>
            <span>|</span>
            <span className="cursor-pointer hover:underline">Terms & Conditions</span>
            <span>|</span>
            <span className="cursor-pointer hover:underline">Terms of Use for API</span>
            <span>|</span>
            <span className="cursor-pointer hover:underline">Sitemap</span>
          </div>

          <p className="leading-[20px]">
            An Avnet Company© 2025 Premier Farnell Limited. All Rights Reserved.
            <br />
            element14 is a trading name of element14 India Private Limited.
            <br />
            Company identity number: U30009KA2007PTC044448 | Registered Office:
            D Block, 11th Floor, IBC Knowledge Park, 4/1, Bannerghatta Main Rd,
            Bhavani Nagar, Suddagunte Palya, Bangalore, Karnataka 560029, India.
          </p>
        </div>
      </div>
    </footer>
  );
}
